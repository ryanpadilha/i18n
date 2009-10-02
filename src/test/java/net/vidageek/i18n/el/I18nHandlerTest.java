package net.vidageek.i18n.el;

import junit.framework.Assert;
import net.vidageek.i18n.message.BundleLocator;
import net.vidageek.i18n.message.LanguageLocator;
import net.vidageek.i18n.message.MessageFactory;

import org.junit.Before;
import org.junit.Test;

/**
 * @author jonasabreu
 * 
 */
final public class I18nHandlerTest {

    private MessageFactory factory;

    @Before
    public void setup() {
        factory = new MessageFactory(new LanguageLocator(), new BundleLocator());
    }

    @Test
    public void testThatLocalizeMessage() {
        I18nHandler handler = new I18nHandler("test", factory);
        Assert.assertEquals("this is a test", handler.toString());
    }

    @Test
    public void testThatOutputSomethingWhenKeyIsNotFound() {
        I18nHandler handler = new I18nHandler("some.key.that.does.not.exist", factory);
        Assert.assertEquals("??? some.key.that.does.not.exist ???", handler.toString());
    }
}
