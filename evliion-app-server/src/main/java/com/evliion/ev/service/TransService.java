package com.evliion.ev.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import com.evliion.ev.repository.*;
import com.evliion.ev.model.*;
@Service
public class TransService {

	  @Autowired
	    private PollRepository pollRepository;

	    @Autowired
	    private VoteRepository voteRepository;

	    @Autowired
	    private UserRepository userRepository;

	    @Autowired
	    private VehicleRepository vehicleRepository;
	    
	    @Autowired 
	    private TransRepository transRepository;

    private static final Logger logger = LoggerFactory.getLogger(PollService.class);

	public boolean createTrans(Transaction transaction)
	{
	     long userId = transaction.getUserId();
	     if(userRepository.existsById(userId))
	     {
			transRepository.saveAndFlush(transaction);
	    	 return true;
	     }
	     return false;
	}
	
}
