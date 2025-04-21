package com.example.data_level_access_control;

import com.example.data_level_access_control.model.Contact;
import com.example.data_level_access_control.model.Merchant;
import com.example.data_level_access_control.repository.ContactRepository;
import com.example.data_level_access_control.repository.MerchantRepository;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	private static MerchantRepository merchantRepository = null;
  private static ContactRepository contactRepository = null;

  public Application(MerchantRepository merchantRepository, ContactRepository contactRepository) {
    this.merchantRepository = merchantRepository;
    this.contactRepository = contactRepository;
  }

  public static void main(String[] args) {

		SpringApplication.run(Application.class, args);

		Merchant illidan = merchantRepository.save(Merchant.builder().name("illidan").paymentCurrency("USD").processingCurrency("CAD").build());
    Merchant malfurion = merchantRepository.save(Merchant.builder().name("malfurion").paymentCurrency("GBP").processingCurrency("INR").build());
    Merchant arthur = merchantRepository.save(Merchant.builder().name("arthur").paymentCurrency("GBP").processingCurrency("INR").build());

    contactRepository.save(Contact.builder().firstName("night").lastName("elves").merchant(illidan).build());
    contactRepository.save(Contact.builder().firstName("demon").lastName("hunter").merchant(illidan).build());
	}

}
