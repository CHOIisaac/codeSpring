package org.zerock.domain;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class SampleDTOList {
    private List<String> list;

    public SampleDTOList(){
        list = new ArrayList<>();
    }
}
