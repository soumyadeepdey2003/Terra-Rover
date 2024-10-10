package trex.autonomous.terrarover.Config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.core.MessageProducer;
import org.springframework.integration.mqtt.core.DefaultMqttPahoClientFactory;
import org.springframework.integration.mqtt.core.MqttPahoClientFactory;
import org.springframework.integration.mqtt.inbound.MqttPahoMessageDrivenChannelAdapter;
import org.springframework.integration.mqtt.outbound.MqttPahoMessageHandler;
import org.springframework.integration.mqtt.support.DefaultPahoMessageConverter;
import org.springframework.integration.mqtt.support.MqttHeaders;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;
import trex.autonomous.terrarover.model.GasSensorModel;
import trex.autonomous.terrarover.model.HumanSensingModel;
import trex.autonomous.terrarover.model.SensorModel;
import trex.autonomous.terrarover.service.*;

import java.util.Objects;

@Configuration
@RequiredArgsConstructor
public class MqttBean {

    private final SensorService sensorService;
    private final GasSensorService gasSensorService;
    private final HumanSensingService humanSensingService;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Bean
    public MqttPahoClientFactory mqttClientFactory() {
        DefaultMqttPahoClientFactory factory = new DefaultMqttPahoClientFactory();
        MqttConnectOptions options = new MqttConnectOptions();
        options.setServerURIs(new String[]{"tcp://localhost:1883"});
        options.setCleanSession(true);
        options.setUserName("Soumya");
        options.setPassword(("soumya@0210").toCharArray());
        factory.setConnectionOptions(options);
        return factory;
    }

    @Bean
    public MessageChannel mqttInputChannel() {
        return new DirectChannel();
    }

    @Bean
    public MessageProducer inbound() {
        MqttPahoMessageDrivenChannelAdapter adapter = new MqttPahoMessageDrivenChannelAdapter(
                "terrarover",
                mqttClientFactory(),
                "#");
        adapter.setCompletionTimeout(5000);
        adapter.setConverter(new DefaultPahoMessageConverter());
        adapter.setQos(2);
        adapter.setOutputChannel(mqttInputChannel());
        return adapter;
    }

    @Bean
    @ServiceActivator(inputChannel = "mqttInputChannel")
    public MessageHandler handler() {
        return message -> {
            String topic = Objects.requireNonNull(message.getHeaders().get(MqttHeaders.RECEIVED_TOPIC)).toString();
            String payload = message.getPayload().toString();

            switch (topic) {
                case "sensor/Sensor":
                    SensorModel sensorModel = null;
                    try {
                        sensorModel = parseSensorModel(payload);
                    } catch (JsonProcessingException e) {
                        throw new RuntimeException(e);
                    }
                    sensorService.addSensorData(sensorModel);
                    break;
                case "sensor/gasSensor":
                    GasSensorModel gasSensorModel = null;
                    try {
                        gasSensorModel = parseGasSensorModel(payload);
                    } catch (JsonProcessingException e) {
                        throw new RuntimeException(e);
                    }
                    gasSensorService.addGasSensorData(gasSensorModel);
                    break;
                case "sensor/humanSensing":
                    HumanSensingModel humanSensingModel = null;
                    try {
                        humanSensingModel = parseHumanSensingModel(payload);
                    } catch (JsonProcessingException e) {
                        throw new RuntimeException(e);
                    }
                    humanSensingService.addHumanSensingData(humanSensingModel);
                    break;
                default:
                    break;
            }
        };
    }

    private SensorModel parseSensorModel(String payload) throws JsonProcessingException {
        return objectMapper.readValue(payload, SensorModel.class);
    }

    private GasSensorModel parseGasSensorModel(String payload) throws JsonProcessingException {
        return objectMapper.readValue(payload, GasSensorModel.class);
    }

    private HumanSensingModel parseHumanSensingModel(String payload) throws JsonProcessingException {
        return objectMapper.readValue(payload, HumanSensingModel.class);
    }

    @Bean
    public MessageChannel mqttOutboundChannel() {
        return new DirectChannel();
    }

    @Bean
    @ServiceActivator(inputChannel = "mqttOutboundChannel")
    public MessageHandler outbound() {
        MqttPahoMessageHandler handler = new MqttPahoMessageHandler("terrarover", mqttClientFactory());
        handler.setAsync(true);
        handler.setDefaultTopic("#");
        handler.setDefaultRetained(false);
        return handler;
    }
}