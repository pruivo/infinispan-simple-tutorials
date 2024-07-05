package org.infinispan.tutorial.simple.remote.query;

import org.infinispan.protostream.annotations.ProtoField;
import org.infinispan.protostream.annotations.ProtoTypeId;

@ProtoTypeId(70000)
public class AnotherEntity {

    @ProtoField(1)
    String realmId;

    public AnotherEntity(String realmId) {
        this.realmId = realmId;
    }

    // for protostream
    public AnotherEntity() {
    }
}
