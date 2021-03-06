package com.github.ilyes4j.gwt.mdl.demo.modules.dropdowns;

import static com.github.ilyes4j.gwt.mdl.components.buttons.ButtonColor.BTN_NO_COLOR;
import static com.github.ilyes4j.gwt.mdl.components.ripples.Ripple.HAS_RIPPLE;
import static com.google.gwt.user.client.ui.RootPanel.get;

import com.github.ilyes4j.gwt.mdl.components.buttons.Button;
import com.github.ilyes4j.gwt.mdl.demo.Demo;
import com.github.ilyes4j.gwt.mdl.extensions.menus.Dropdown;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.RootPanel;

/** Setup a programmatic item selection for a dropdown menu. */
public class SelectItemDemo implements EntryPoint {

  /** When the command button is pushed the next item is selected. */
  public final void onModuleLoad() {

    // retrieve the container
    RootPanel ctnr = get("selectContainer");

    // attach the toggle to its parent
    Button select = Button.createRaised(BTN_NO_COLOR, HAS_RIPPLE, "Select");
    ctnr.add(select);

    // instanciate a dropdown
    final Dropdown dropdown = new Dropdown();
    dropdown.addStyleName(Demo.DEMO.css().inline());

    // add the items to the dropdown
    dropdown.addItem("Some action");
    dropdown.addItem("Another action");
    dropdown.addItem("Yet another action");

    // attach the dropdown to its parent
    ctnr.add(dropdown);

    select.addClickHandler(new ClickHandler() {

      @Override
      public void onClick(final ClickEvent event) {
        int next = (dropdown.getSelected() + 1) % dropdown.getItemCount();
        dropdown.setSelected(next);
      }
    });
  }
}
