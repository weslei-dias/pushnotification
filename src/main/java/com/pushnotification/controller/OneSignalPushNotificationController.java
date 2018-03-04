package com.pushnotification.controller;

import com.pushnotification.model.OneSignalPushNotification;
import com.pushnotification.repository.OneSignalPushNotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Create by Weslei Dias.
 **/
@RestController
@RequestMapping("/pushnotification")
public class OneSignalPushNotificationController {

    @Autowired
    private OneSignalPushNotificationRepository repository;

    @PostMapping("/sendMessageToAllUsers/{message}")
    public void sendMessageToAllUsers(@PathVariable("message") String message)
    {
        PushNotificationOptions.sendMessageToAllUsers(message);
    }

    @PostMapping("/sendMessageToUser/{userId}/{message}")
    public void sendMessageToUser(@PathVariable("userId") String userId,
                                  @PathVariable("message") String message)
    {
        PushNotificationOptions.sendMessageToUser(message, userId);
    }

    @PostMapping("/saveUserId/{userId}")
    public void saveUserId(@PathVariable("userId") String userId)
    {
        OneSignalPushNotification notification = new OneSignalPushNotification();
        notification.setIdOneSignal(userId);
        notification.setUserName("User: " + userId);
        repository.save(notification);
    }

    @GetMapping("/getUsers")
    public List<Object> getUsers()
    {
        List<Object> listValues = new ArrayList<>();
        for (OneSignalPushNotification notification : repository.findAll()){
            Map<String, Object> mapValues = new HashMap<>();
            mapValues.put("userName", notification.getUserName());
            mapValues.put("idOneSignal", notification.getIdOneSignal());
            listValues.add(mapValues);
        }

        return listValues;
    }

}
