#!/bin/bash

mvn clean package appengine:deploy -Dapp.deploy.version=GCLOUD_CONFIG -Dapp.deploy.projectId=civic-wharf-328219 -Dapp.deploy.promote=true
