package com.example;

// Parent class
class Animal {

	
	public void speak(String animal) {

		System.out.println(animal + " makes a sound");

	}

}

class Dog {

}

class Cat extends Animal ,Dog {

}

public class April18 {
	public static void main(String[] args) {

		Dog dog = new Dog();
		Cat cat = new Cat();

		dog.speak("Dog");
		cat.speak("Cat");
	}
}
