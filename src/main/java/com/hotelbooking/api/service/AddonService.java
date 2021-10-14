package com.hotelbooking.api.service;

import java.util.List;

import com.hotelbooking.api.entity.Addon;

public interface AddonService extends Service<Addon>{
    Addon getAddonByName(String name);
}

