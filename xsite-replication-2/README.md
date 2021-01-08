Cross site replication cluster
==============================
**Technologies:** Infinispan Server, Cross-Site replication, Console

**Summary:** Run two Infinispan clusters locally to learn how cross-site replication works.

About This Tutorial
-------------------

In this tutorial, you start two Infinispan clusters, called Site1 and Site2, that provide backups for each other.

This tutorial demonstrates Infinispan cross-site replication capabilities locally without any image or other tool.
In production environments, Infinispan clusters are typically located in different data centers.

Requirements
------------

* Java 8 or Java 11

Procedure
---------

* Download the server zip from [Infinispan website](https://infinispan.org/download/#stable).

* Unzip the server.

```bash
unzip infinispan-server-<version>.zip
cd infinispan-server-<version>
export ISPN_HOME=$PWD
```

* Add an user to acces the cluster with username  `demo` and password `demo`.

```bash
$ISPN_HOME/bin/cli.sh user create demo -p demo
```

* Copy `infinispan-site1.xml` and `infinispan-site2.xml` from this folder to `$ISPN_HOME/server/conf`.

* Create configuration and data folders for both sites by copying the original `$ISPN_HOME/server` folder.

```bash
    cp -r $ISPN_HOME/server/ site1
cp -r $ISPN_HOME/server/ site2
```

* Start node in site1

```bash
$ISPN_HOME/bin/server.sh --server-root=site1 --server-config=infinispan-site1.xml
```

* In another terminal, start node in site 2

```bash
$ISPN_HOME/bin/server.sh --server-root=site1 --server-config=infinispan-site1.xml --port-offset=10
```

* If everything is fine, you will see the following message:

Node on site1
```
[org.infinispan.XSITE] ISPN000439: Received new x-site view: [site1]
[org.infinispan.XSITE] ISPN000439: Received new x-site view: [site1, site2]
```

Node on site2
```
[org.infinispan.XSITE] ISPN000439: Received new x-site view: [site1, site2]
```