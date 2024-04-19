package com.hg.gym.model;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "members")
public class Member {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	  private Long id;
	private String name;
	private String email;
	  private LocalDate startDate;
	  private Plan plan;

	  public enum Plan {
	    MONTH,
	    QUARTER,
	    YEAR
	  }
	
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public LocalDate getStartDate() {
		return startDate;
	}


	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}


	public Plan getPlan() {
		return plan;
	}


	public void setPlan(Plan plan) {
		this.plan = plan;
	}


	public boolean isActive() {
          LocalDate currentDate = LocalDate.now();
          long durationInMonths;

          switch (plan) {
              case MONTH:
                  durationInMonths = 1;
                  break;
              case QUARTER:
                  durationInMonths = 3;
                  break;
              case YEAR:
                  durationInMonths = 12;
                  break;
              default:
                  throw new IllegalArgumentException("Invalid membership plan: " + plan);
          }

          LocalDate expirationDate = startDate.plusMonths(durationInMonths);
          return !currentDate.isAfter(expirationDate);
      }

}
