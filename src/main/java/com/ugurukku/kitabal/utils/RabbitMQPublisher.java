package com.ugurukku.kitabal.utils;

import com.ugurukku.kitabal.dto.email.EmailDto;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class RabbitMQPublisher {

	private final AmqpTemplate rabbitTemplate;

	@Value("${rabbitmq.exchange}")
	private String exchange;

	@Value("${rabbitmq.routingkey}")
	private String routingkey;

	public void send(EmailDto emailDto) {
		rabbitTemplate.convertAndSend(exchange, routingkey, emailDto);
		System.out.println("Send msg = " + emailDto);
	}
}