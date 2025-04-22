package com.example.data_level_access_control.Controller;


import com.example.data_level_access_control.model.Contact;
import com.example.data_level_access_control.model.Merchant;
import com.example.data_level_access_control.repository.ContactRepository;
import com.example.data_level_access_control.repository.MerchantRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.Optional;

@Controller
public class GraphqlController {
  private final MerchantRepository merchantRepository;
  private final ContactRepository contactRepository;

  public GraphqlController(MerchantRepository merchantRepository, ContactRepository contactRepository) {
    this.merchantRepository = merchantRepository;
    this.contactRepository = contactRepository;
  }


  @QueryMapping
  Iterable<Merchant> merchants() {
    return merchantRepository.findAll();
  }


  @QueryMapping
  Optional<Merchant> merchantById(@Argument Long id) {
    return merchantRepository.findById(id);
  }

  @MutationMapping
  Optional<Merchant> addContact(@Argument ContactInput contactInput) {
    Optional<Merchant> merchant = merchantRepository.findById(contactInput.contactId);

    Contact newContact = Contact.builder()
        .firstName(contactInput.firstName)
        .lastName(contactInput.lastName)
        .merchant(merchant.get()).build();
    contactRepository.save(newContact);

    return merchantRepository.findById(contactInput.contactId);
  }

  record ContactInput(String firstName, String lastName, Long contactId) {}
}
