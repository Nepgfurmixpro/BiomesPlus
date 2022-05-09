package com.neothedeveloper.biomesplus.client.rendering;

import java.util.ArrayList;
import java.util.List;

public class UIElementRegistry {
    private static final List<UIElement> uiElements = new ArrayList<>();
    public static void register(UIElement element) {
        uiElements.add(element);
    }
    public static List<UIElement> getRegistry() {
        return uiElements;
    }
}
