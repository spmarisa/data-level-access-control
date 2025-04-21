package com.example.data_level_access_control.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Merchant {
  private String id;
  private String name;
  private String paymentCurrency;
  private String processingCurrency;
  private List<Contact> contacts;
}
