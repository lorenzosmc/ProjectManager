package com.github.lorenzosmc.projectmanager.model.context;

import java.time.Instant;

import com.github.lorenzosmc.projectmanager.model.user.User;

public class FAQTagAssignment {
	private FAQ faq;
	private Tag tag;
	private Instant dateOfAssignment;
	private User assigner;

	public FAQ getFaq() {
		return faq;
	}

	public void setFaq(FAQ faq) {
		this.faq = faq;
	}

	public Tag getTag() {
		return tag;
	}

	public void setTag(Tag tag) {
		this.tag = tag;
	}

	public Instant getDateOfAssignment() {
		return dateOfAssignment;
	}

	public void setDateOfAssignment(Instant dateOfAssignment) {
		this.dateOfAssignment = dateOfAssignment;
	}

	public User getAssigner() {
		return assigner;
	}

	public void setAssigner(User assigner) {
		this.assigner = assigner;
	}
}
