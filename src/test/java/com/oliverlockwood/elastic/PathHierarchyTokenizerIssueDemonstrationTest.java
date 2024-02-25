package com.oliverlockwood.elastic;

import co.elastic.clients.elasticsearch.indices.PutIndexTemplateRequest;
import org.junit.jupiter.api.Test;

import java.io.StringReader;


public class PathHierarchyTokenizerIssueDemonstrationTest {

    @Test
    void doTest() {
        String indexTemplate = """
                {
                  "template": {
                    "settings": {
                      "analysis": {
                        "tokenizer": {
                          "path_tokenizer": {
                            "type": "path_hierarchy"
                          }
                        }
                      }
                    }
                  }
                }""";

        PutIndexTemplateRequest putIndexTemplateRequest = PutIndexTemplateRequest.of(pitr -> pitr
                .name("template-things")
                .indexPatterns("things-*")
                .withJson(new StringReader(indexTemplate)));
    }

}
