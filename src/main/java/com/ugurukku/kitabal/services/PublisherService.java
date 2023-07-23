package com.ugurukku.kitabal.services;

import com.ugurukku.kitabal.dto.PublisherRequest;
import com.ugurukku.kitabal.entities.Publisher;

import java.util.List;

public interface PublisherService  {

    List<Publisher> getAll();

    void add(PublisherRequest publisherRequest);

}
