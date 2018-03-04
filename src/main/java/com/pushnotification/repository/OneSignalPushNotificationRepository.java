package com.pushnotification.repository;

import com.pushnotification.model.OneSignalPushNotification;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Weslei Dias.
 */
public interface OneSignalPushNotificationRepository extends
        JpaRepository<OneSignalPushNotification, Long> {
}
