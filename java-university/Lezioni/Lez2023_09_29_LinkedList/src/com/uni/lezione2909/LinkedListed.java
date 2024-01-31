package com.uni.lezione2909;
import java.util.LinkedList;


public class LinkedListed {
	public static void main(String[] args) {
		LinkedList<Persona> l;
		l = new LinkedList <Persona>();
		l.add(new Persona("Lucia", 1993));
		l.add(new Studente ("Gianni", 2001, 1234567));
		l.add(0, new Persona("Maria", 1995));
		System.out.println(l);
		
		
		
	}

}
