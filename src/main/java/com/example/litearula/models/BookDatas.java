package com.example.litearula.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record BookDatas(int id,
                        String title,
                        @JsonAlias ("download_count") double downloadCount,
                        List<AuthorDatas> authors,
                        List<String> languages){
    @Override
    public String toString() {
        return "title = " + title() +
                ", authors = " + authors().get(0).name() +
                ", languages = " + languages().get(0) +
                ", id = " + id() +
                ", downloadCount = " + downloadCount();
    }
}
