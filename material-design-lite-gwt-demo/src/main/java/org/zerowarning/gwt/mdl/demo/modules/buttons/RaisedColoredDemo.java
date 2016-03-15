package org.zerowarning.gwt.mdl.demo.modules.buttons;

import static com.google.gwt.user.client.ui.RootPanel.get;
import static org.zerowarning.gwt.mdl.components.buttons.Button.createRaised;
import static org.zerowarning.gwt.mdl.components.buttons.ButtonColor.ACCENT;
import static org.zerowarning.gwt.mdl.components.buttons.ButtonColor.PRIMARY;
import static org.zerowarning.gwt.mdl.components.ripples.Ripple.HAS_RIPPLE;
import static org.zerowarning.gwt.mdl.components.ripples.Ripple.NONE;

import com.google.gwt.core.client.EntryPoint;

/** Raised colored buttons demo. */
public class RaisedColoredDemo implements EntryPoint {

  /** When the page loads add the buttons. */
  public final void onModuleLoad() {

    // the text inside the buttons
    final String txt = "Button";

    // create a colored button with a ripple
    get("ctnr_09").add(createRaised(PRIMARY, NONE, txt));

    // create an accent colored button
    get("ctnr_10").add(createRaised(ACCENT, NONE, txt));

    // create an accent colored button with a ripple
    get("ctnr_11").add(createRaised(ACCENT, HAS_RIPPLE, txt));
  }
}
