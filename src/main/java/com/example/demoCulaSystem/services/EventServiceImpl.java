package com.example.demoCulaSystem.services;

import com.example.demoCulaSystem.exceptions.EventException;

import com.example.demoCulaSystem.model.Event;

import com.example.demoCulaSystem.repos.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventServeice {

    private final EventRepository eventRepository;

    @Override
    public Event createEvent(Event event) throws EventException {
        if (eventRepository.existsByTitle(event.getTitle())) {
            throw new EventException("this title is already used");

        }
        return eventRepository.save(event);
    }


    @Override
    public Event updateEvent(Event event) throws EventException {
        return eventRepository.saveAndFlush(event);

    }

    @Override
    public void deleteEvent(Long id) throws EventException {
        if (!eventRepository.existsById(id)) {
            throw new EventException("this event doesn't exists");
        }
        eventRepository.deleteById(id);
    }


    @Override
    public List<Event> getAllEvents() throws EventException {
        if (eventRepository.findAll().isEmpty()) {
            throw new EventException("sorry, no events to show yet");
        }
        return eventRepository.findAll();

    }
}
