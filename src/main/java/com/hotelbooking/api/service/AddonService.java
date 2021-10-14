package com.hotelbooking.api.service;

import com.hotelbooking.api.entity.Addon;

public interface AddonService extends Service<Addon>{
    Addon getAddonByName(String name);
}

