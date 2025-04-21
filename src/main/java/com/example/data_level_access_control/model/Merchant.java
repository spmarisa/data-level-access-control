package com.example.data_level_access_control.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties
public class Merchant {
  @Id
  @GeneratedValue
  private Long id;
  private String name;
  private String paymentCurrency;
  private String processingCurrency;
  @OneToMany(mappedBy = "merchant", cascade = CascadeType.ALL)
  private List<Contact> contacts = new ArrayList<>();
}
