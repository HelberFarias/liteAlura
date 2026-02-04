package com.example.litearula.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties (ignoreUnknown = true)
public record ContainerBook (List<BookDatas> results) {}
