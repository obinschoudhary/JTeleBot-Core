/**
 * 
 * Copyright (C) 2015 Roberto Dominguez Estrada and Juan Carlos Sedano Salas
 *
 * This material is provided "as is", with absolutely no warranty expressed
 * or implied. Any use is at your own risk.
 *
 */
package io.github.nixtabyte.telegram.jtelebot.server;

/**
 * This class represents a queue to store {@link Command} instances that could
 * be later dispatched in a chronological order, depending on the executor
 * implementation.
 * 
 * 
 * @see Command
 * @since 0.0.1
 * */
public interface CommandQueue {

	/**
	 * Method to add a new {@link Command} to the queue tail.
	 * 
	 * @param command
	 *            Is the command object being stored at the end of queue.
	 * */
	public void add(Command command);

	/**
	 * Method to retrieve and remove the {@link Command} object from the queue's
	 * head.
	 * 
	 * @return The {@link Command} object removed or null if empty.
	 * */
	public Command poll();

	/**
	 * Method to check the size of queue based on the elements stored.
	 * 
	 * @return Returns the number of elements in the queue.
	 * */
	public int size();

	/**
	 * Method to check whether the queue has elements or not.
	 * 
	 * @return Returns <b>true</b> if this queue contains no element or
	 *         <b>false</b> otherwise.
	 * */
	public boolean isEmpty();

	/**
	 * Method to check if any {@link Command} instance is enqueued or not.
	 * 
	 * @return Returns <b>true</b> if the given Command is inside the queue or
	 *         <b>false</b> otherwise.
	 * */
	public boolean contains(Command command);

}
