package com.stackroute.trackservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import javax.persistence.Id;


@NoArgsConstructor
// Creates default constructor
@AllArgsConstructor
// Creates parameterized constructor with all properties
@Data
//Creates getter,setter,toString methods
@Document(collection = "track")
// Document annotation used for MongoDB

public class Track
{
    @Id
    //Creates primary key as trackId
    private int trackId;
    private String trackName;
    private String comments;
}
