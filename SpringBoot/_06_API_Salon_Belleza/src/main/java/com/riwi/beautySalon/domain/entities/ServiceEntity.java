package com.riwi.beautySalon.domain.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Entity(name = "service")
@Data
@Builder // -> creación de clases
@AllArgsConstructor
@NoArgsConstructor
public class ServiceEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY) // IDENTITY (autoincrement)
  private Long id;
  @Column(length = 100, nullable = false)
  private String name;
  @Lob // -> Declara el atributo como tipo TEXT
  private String description;
  @Column(nullable = false)
  private BigDecimal price;

  @ToString.Exclude
  @EqualsAndHashCode.Exclude
  @OneToMany(
          mappedBy = "service",
          fetch = FetchType.EAGER,
          cascade = CascadeType.ALL,
          orphanRemoval = true
  )
  private List<Appointment> appointments;
}
