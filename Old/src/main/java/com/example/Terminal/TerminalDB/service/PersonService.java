package com.example.Terminal.TerminalDB.service;
import com.example.Terminal.TerminalDB.entity.Person;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.concurrent.ExecutionException;

@Service
public class PersonService {

    private static final String COLLECTION_NAME = "users";



    public static String savePerson(Person person) throws ExecutionException, InterruptedException {

       Firestore dbFireStore= FirestoreClient.getFirestore();

       ApiFuture<WriteResult> collectionApiFuture= dbFireStore.collection(COLLECTION_NAME).document(person.getName()).set(person);

       return collectionApiFuture.get().getUpdateTime().toString();
    }

    public static Person getPersonDetails(String name) throws ExecutionException, InterruptedException {

        Firestore dbFireStore= FirestoreClient.getFirestore();

        DocumentReference documentReference= dbFireStore.collection(COLLECTION_NAME).document(name);

        ApiFuture<DocumentSnapshot> future = documentReference.get();
        DocumentSnapshot document = future.get();
        Person person = null;
        if(document.exists()){
             person = document.toObject(Person.class);
            return person;
        }
        else{
            return null;
        }

    }
    public static String updatePerson(Person person) throws ExecutionException, InterruptedException {

        Firestore dbFireStore= FirestoreClient.getFirestore();

        ApiFuture<WriteResult> collectionApiFuture= dbFireStore.collection(COLLECTION_NAME).document(person.getName()).set(person);

        return collectionApiFuture.get().getUpdateTime().toString();
    }

    public static String deletePerson(String name) throws ExecutionException, InterruptedException {

        Firestore dbFireStore= FirestoreClient.getFirestore();

        ApiFuture<WriteResult> collectionApiFuture= dbFireStore.collection(COLLECTION_NAME).document(name).delete();

        return "User " + name + " has been deleted";
    }

}
