package com.github.ilyes4j.gwt.mdl;

import static com.github.ilyes4j.gwt.mdl.components.buttons.ButtonColor.BTN_NO_COLOR;
import static com.github.ilyes4j.gwt.mdl.components.ripples.Ripple.HAS_RIPPLE;
import static java.util.logging.Logger.getLogger;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.github.ilyes4j.gwt.mdl.components.buttons.Button;
import com.github.ilyes4j.gwt.mdl.components.menus.Menu;
import com.github.ilyes4j.gwt.mdl.components.menus.MenuAnchor;
import com.github.ilyes4j.gwt.mdl.components.menus.MenuCombo;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Tests for the {@link Menu} component.
 * 
 * @author Mohamed Ilyes DIMASSI
 *
 */
public class MdlGwtMenuTest extends MdlGwtBaseTest {

  /**
   * The menu should not allow being upgraded without insuring it is bound to an
   * action button.
   */
  public final void testNoActionId() {

    try {

      // setup a menu
      Menu menu = new Menu();

      // attach the menu before associating it to a button.
      RootPanel.get().add(menu);

      // fail the test if the menu does not rise an exception
      assertTrue(false);

    } catch (IllegalStateException ise) {

      // pass the test when the menu raises the appropriate exception
      assertTrue(true);
    }
  }

  /**
   * It shouldn't be allowed to change the action button after menu upgrade.
   */
  public final void testChangeActionId() {

    try {
      // attach the first action button
      final String btn1Id = "Action1";
      Button btn1 = Button.createRaised(BTN_NO_COLOR, HAS_RIPPLE, "Action#1");
      btn1.getElement().setAttribute("id", btn1Id);
      RootPanel.get().add(btn1);

      // attach the second action button
      final String btn2Id = "Action2";
      Button btn2 = Button.createRaised(BTN_NO_COLOR, HAS_RIPPLE, "Action#2");
      btn2.getElement().setAttribute("id", btn2Id);
      RootPanel.get().add(btn2);

      // setup the menu
      Menu menu = new Menu();
      // bind the menu to an action button
      menu.setActionId(btn1Id);

      // attach the menu to DOM
      RootPanel.get().add(menu);

      // raise an exception while attempting to change the action button
      menu.setActionId(btn2Id);

      // fail the test if the menu does not rise an exception
      assertTrue(false);

    } catch (IllegalStateException ise) {

      // pass the test when the menu raises the appropriate exception
      assertTrue(true);
    }
  }

  /**
   * The menu doesn't (yet) support adding items after the menu is upgraded. If
   * an item is added to the menu after the upgrade, an exception should be
   * raised.
   */
  public final void testAddItem() {

    try {

      RootPanel root = RootPanel.get();

      // setup a button and add attach it to the DOM
      final String mnId = "btn";
      Button btn = Button.createRaised(BTN_NO_COLOR, HAS_RIPPLE, "Menu");
      btn.getElement().setAttribute("id", mnId);
      root.add(btn);

      // setup a menu
      Menu menu = new Menu();
      menu.setActionId(mnId);

      // attach the menu
      RootPanel.get().add(menu);

      // raise an exception while attempting to add an item
      menu.addItem("Some Item");

      // fail the test if the menu does not raise the appropriate exception
      assertTrue(false);

    } catch (IllegalStateException ise) {

      // pass the test when the menu raises the appropriate exception
      assertTrue(true);
    }
  }

  /**
   * Check that the menu doesn't allow anchors to be set after upgrade.
   */
  public final void testAnchorRegistered() {

    try {

      Button btn = Button.createRaised(BTN_NO_COLOR, HAS_RIPPLE, "Anchor");

      // setup a menu
      final MenuCombo menu = new MenuCombo(btn);

      // attach the menu to DOM
      RootPanel.get().add(menu);

      LOG.log(Level.FINE, "Setting anchor to the menu");

      // set the anchoring of the menu
      menu.setAnchor(MenuAnchor.TOP_LEFT);

      // fail the test if the menu does not rise an exception
      assertTrue(false);

    } catch (IllegalStateException ise) {

      // pass the test when the menu raises the appropriate exception
      assertTrue(true);
    }
  }

  /**
   * Menu tests logger.
   */
  private static final Logger LOG = getLogger(MdlGwtMenuTest.class.getName());
}
