package com.github.lorenzosmc.projectmanager.model.faq;

import com.github.lorenzosmc.projectmanager.model.context.Context;

public class FAQContextMapper {
	private FAQ faq;
	private Context context;
	private boolean visible;

	public FAQ getFaq() {
		return faq;
	}

	public void setFaq(FAQ faq) {
		this.faq = faq;
	}

	public Context getContext() {
		return context;
	}

	public void setContext(Context context) {
		this.context = context;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}
}
