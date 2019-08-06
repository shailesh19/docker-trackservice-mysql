package com.stackroute.trackservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@Entity
@NoArgsConstructor
// creates default constructor
@AllArgsConstructor
// creates parameterized constructor with all properties
@Data
public class Track
{
    @Id
    private int trackId;
    private String trackName;
    private String comments;
}
