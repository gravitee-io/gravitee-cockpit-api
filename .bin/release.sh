#!/usr/bin/env bash

ORG_NAME="gravitee-io"
REPO_NAME="gravitee-cockpit-api"
BRANCH="${BRANCH:=master}"
DRY_RUN="${DRY_RUN:=true}"
JSON_PAYLOAD="{

    \"branch\": \"${BRANCH}\",
    \"parameters\":

    {
      \"gio_action\": \"standalone_release\",
      \"dry_run\": ${DRY_RUN}
    }

}"

curl -X GET -H 'Content-Type: application/json' -H 'Accept: application/json' -H "Circle-Token: ${CCI_TOKEN}" https://circleci.com/api/v2/me | jq .
curl -X POST -d "${JSON_PAYLOAD}" -H 'Content-Type: application/json' -H 'Accept: application/json' -H "Circle-Token: ${CCI_TOKEN}" https://circleci.com/api/v2/project/gh/${ORG_NAME}/${REPO_NAME}/pipeline | jq .