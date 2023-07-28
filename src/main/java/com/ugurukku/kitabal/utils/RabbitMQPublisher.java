package com.ugurukku.kitabal.utils;

import com.ugurukku.kitabal.dto.email.EmailDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
@Slf4j
public class RabbitMQPublisher {

	private final AmqpTemplate rabbitTemplate;

	@Value("${rabbitmq.exchange}")
	private String exchange;

	@Value("${rabbitmq.routingkey}")
	private String routingkey;

	public void send(EmailDto emailDto) {
		rabbitTemplate.convertAndSend(exchange, routingkey, emailDto);
		log.info("Email sent to rabbitmq for : {}",emailDto.getRecipient());
	}
}