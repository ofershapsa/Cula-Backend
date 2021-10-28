package com.example.demoCulaSystem.services;

import com.example.demoCulaSystem.exceptions.EventException;
import com.example.demoCulaSystem.exceptions.UserException;
import com.example.demoCulaSystem.model.Event;
import com.example.demoCulaSystem.model.Task;

import java.util.List;

public interface EventServeice {

    Event createEvent(Event event) throws EventException;

    Event updateEvent(Event event) throws  EventException;

    void deleteEvent(Long id) throws EventException;

    List<Event> getAllEvents () throws  EventException;
}
