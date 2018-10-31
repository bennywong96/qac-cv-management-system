//package com.qa;
//
//import com.qa.domain.Cv;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
//
//import com.qa.repository.ICvRepository;
//
//@EnableMongoRepositories(basePackageClasses = ICvRepository.class)
//@Configuration
//public class mongoDBConfig implements CommandLineRunner {
//
//    @Autowired
//    private ICvRepository iCvRepository;
//
//    @Override
//    public void run(String... args) {
//
//        iCvRepository.deleteAll();
//
//        // save a couple of customers
//        iCvRepository.save(new Cv("Alice"));
//        iCvRepository.save(new Cv("Bob"));
//
//
//        // fetch all customers
//        System.out.println("Customers found with findAll():");
//        System.out.println("-------------------------------");
//        for (Cv cv: iCvRepository.findAll()) {
//            System.out.println(cv);
//        }
//        System.out.println();
//
//        // fetch an individual customer
//        System.out.println("Customer found with findByFirstName('Alice'):");
//        System.out.println("--------------------------------");
//        System.out.println(iCvRepository.findByName("Alice"));
//
//    }
//}
