package com.roadtonerdvana.jtelebot.server;

public interface CommandQueue {

	/**
	 * Adds a new command to the Queue tail.
	 * */
	public void add(Command command);

	/**
	 * Retrieves and removes the head of this queue, or returns null if this
	 * queue is empty.
	 * */
	public Command poll();

	/**
	 * @return Returns the number of elements in the Queue
	 * */
	public int size();

	/**
	 * @return Returns true if this Queue contains no element; false otherwise.
	 * */
	public boolean isEmpty();

	/**
	 * @return Returns true if given Command is inside the Queue; false
	 *         otherwise.
	 * */
	public boolean contains(Command command);

}
