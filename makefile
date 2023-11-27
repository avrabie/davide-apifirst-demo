#!makefile

COMPOSE_FILE_INFRA = "./etc/docker-local-dev-infra.yml"


docker-infra-up:
    COMPOSE_PROFILE=$(profiles) \
    docker compose -f ${COMPOSE_FILE_INFRA} up -d

docker-infra-down:
    COMPOSE_PROFILE=$(profiles) \
    docker compose -f ${COMPOSE_FILE_INFRA} down

docker-infra-status:
    docker ps -a \
        --filter "name=${COMPOSE_PROJECT_NAME}*" \
        --format "CONTAINER ID : {{.ID}} | Name: {{.Names}} | Image:  {{.Image}} |  Ports: {{.Ports}} | Status: {{.Status}}"

docker-logs:
    docker logs --follow

.PHONY: docker-infra-up \
    docker-infra-down \
    docker-infra-status
