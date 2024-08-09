package com.aop.app.util;

import org.apache.logging.log4j.core.*;
import org.apache.logging.log4j.core.appender.AbstractAppender;
import org.apache.logging.log4j.core.config.Property;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.config.plugins.PluginAttribute;
import org.apache.logging.log4j.core.config.plugins.PluginElement;
import org.apache.logging.log4j.core.config.plugins.PluginFactory;
import org.apache.logging.log4j.core.layout.PatternLayout;

import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Plugin(
    name = "TestAppender", category = Core.CATEGORY_NAME,
    elementType = Appender.ELEMENT_TYPE
)
public class TestAppender extends AbstractAppender {

    private ConcurrentMap<String, LogEvent> eventMap = new ConcurrentHashMap<>();

    protected TestAppender(
        String name, Filter filter,
        Layout<? extends Serializable> layout,
        boolean ignoreExceptions, Property[] properties) {
        super(name, filter, layout, ignoreExceptions, properties);
    }

    @PluginFactory
    public static TestAppender createAppender(
        @PluginAttribute("name") String name,
        @PluginElement("Filters") Filter filter,
        @PluginElement("Layout") Layout<? extends Serializable> layout
    ) {
        if (name == null) {
            LOGGER.error("No name provided for StubAppender");
            return null;
        }
        if (layout == null) {
            layout = PatternLayout.createDefaultLayout();
        }
        return new TestAppender(name, filter, layout, true, null);
    }

    @Override
    public void append(LogEvent event) {
        eventMap.put(event.getMessage().getFormattedMessage(), event);
    }

    public ConcurrentMap<String, LogEvent> getEvents() {
        return eventMap;
    }
}
