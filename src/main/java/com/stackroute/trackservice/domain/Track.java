package com.stackroute.trackservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;


@NoArgsConstructor
// creates default constructor
@AllArgsConstructor
// creates parameterized constructor with all properties
@Data
//@Document(collection = "track")
@Entity
public class Track
{
    @Id
    private int trackId;
    private String trackName;
    private String comments;
}
