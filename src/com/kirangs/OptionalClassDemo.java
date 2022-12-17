package com.kirangs;

import java.util.Optional;

/**
 * Java introduced a new class Optional in JDK 8. It is a public final class and
 * is used to deal with NullPointerException in Java applications.
 * 
 * The purpose of the class is to provide a type-level solution for representing
 * optional values instead of using null references.
 * 
 * Advantages of Java 8 Optional
 *  - Null checks are not required.
 *  - No more NullPointerException at run-time.
 *  - We can develop a clean and neat APIs. 
 *  - No more Boilerplate code
 */
public class OptionalClassDemo {

	public static void main(String[] args) {
		
		String email="kiran@gmail.com";
		
		String nullValue=null;
		
		/**
		 * ways of creating optional objects : empty, of, ofNullable
		 * */
		// empty
		Optional<Object> emptyOptional = Optional.empty();
		System.out.println(emptyOptional); //prints Optional.empty
		
		
		//of : throws null pointer exception if values is null
		Optional<String> emailOptional1=Optional.of(email);
		System.out.println(emailOptional1); //prints Optional[kiran@gmail.com]
		
		
		
		//ofNullable : if we pass non null it will just works as of()
		//if we pass null also it will not throw NullPointerException
		Optional<String> emailOptional2=Optional.ofNullable(nullValue);
		System.out.println(emailOptional2); //prints Optional.empty
		
		
		
		//get() : Gets value from Optional Container if it contains any value
		//else throws NoSuchElementException
		System.out.println(emailOptional1.get()); //prints kiran@gmail.com
		
		
		//emailOptional2 is empty and we can check and print value as below
		if(emailOptional2.isPresent()) {
			System.out.println(emailOptional2.get());
		} else {
			System.out.println("No value present");
		}
		
		
		//use of orElse()
		Optional<String> stringOptional=Optional.ofNullable(null);
		String defaultValue=stringOptional.orElse("default value");
		System.out.println(defaultValue); //prints default value
		
		Optional<String> stringOptional1=Optional.ofNullable("Kiran");
		String defaultValue1=stringOptional1.orElse("default value");
		System.out.println(defaultValue1); //prints kiran
		
		
		
		//use of orElseGet()
		Optional<Integer> marks = Optional.ofNullable(null);
		Integer defaultMarks = marks.orElseGet(()-> 0);
		System.out.println(defaultMarks);
		
		Optional<Integer> marks1 = Optional.ofNullable(98);
		Integer defaultMarks1 = marks1.orElseGet(()-> 0);
		System.out.println(defaultMarks1);
		
		
		//use of orElseThrow()
	//	Integer marksNotExists = marks.orElseThrow(()-> new IllegalArgumentException("No Marks Exists"));
	//	System.out.println(marksNotExists);
		
		//ifPresent()
		Optional<String> maleGender=Optional.of("MALE");
		Optional<String> femaleGender=Optional.empty();
		
		maleGender.ifPresent(gender-> System.out.println(gender)); //prints MALE
		femaleGender.ifPresent(gender->System.out.println(gender)); //will not print anything because no value present in optional object
		
		
		//use of filter()  and map()
		
		String string=" abc";
		if(string!=null && string.contains(string)) {
			System.out.println(string);
		}
		
		Optional<String> optionalStr=Optional.of(string);
		
		optionalStr
		.filter(string2->string.contains("abc"))
		.map(str->str.trim())
		.ifPresent(string1-> System.out.println(string1));

	}

}
