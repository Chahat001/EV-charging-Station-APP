package com.evliion.ev.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.evliion.ev.exception.ResourceNotFoundException;
import com.evliion.ev.model.Card;
import com.evliion.ev.model.Poll;
import com.evliion.ev.model.User;
import com.evliion.ev.payload.CardRequest;
import com.evliion.ev.payload.CardResponse;
import com.evliion.ev.payload.PollResponse;
import com.evliion.ev.repository.CardRepository;
import com.evliion.ev.repository.UserRepository;
import com.evliion.ev.util.ModelMapper;

@Service
public class CardService {

	@Autowired
	private CardRepository cardRepository;

	@Autowired
	private UserRepository userRepository;

	private static final Logger logger = LoggerFactory.getLogger(CardService.class);

	public Card addCard(CardRequest cardRequest) {
		Card card = new Card();
		card.setExpMonth(cardRequest.getExpMonth());
		card.setExpYear(cardRequest.getExpYear());
		card.setName(cardRequest.getName());
		card.setNumber(cardRequest.getNumber());

		User user = userRepository.findById(cardRequest.getUserId())
				.orElseThrow(() -> new ResourceNotFoundException("User", "userId", cardRequest.getUserId()));

		card.setUser(user);
		return cardRepository.save(card);
	}

	public CardResponse getCardById(Long cardId) {
		Card card = cardRepository.findById(cardId).orElseThrow(
				()-> new ResourceNotFoundException("Card", "id", cardId));
		 
		return ModelMapper.mapCardToCardResponse(card);		
	}

	public List<CardResponse> getPaymentMethodsByUserId(Long userId) {
		
        List<Card> cards = cardRepository.findByUserId(userId);
		
		List<CardResponse> cardResponses  = cards.stream()
				.map(card -> ModelMapper.mapCardToCardResponse(card))
				.collect(Collectors.toList());
		return cardResponses;
				
	}

}
