# See here for image contents: https://github.com/microsoft/vscode-dev-containers/tree/v0.231.6/containers/java-8/.devcontainer/base.Dockerfile

ARG VARIANT="buster"
FROM mcr.microsoft.com/vscode/devcontainers/java:0-8-${VARIANT}

EXPOSE 22

ARG USERNAME=vscode

RUN mkdir -p /home/${USERNAME}/.vscode-server/extensions /home/${USERNAME}/.vscode-server-insiders/extensions \
  && chown -R ${USERNAME} /home/${USERNAME}/.vscode-server /home/${USERNAME}/.vscode-server-insiders \
  && apt-get update \
  && export DEBIAN_FRONTEND=noninteractive \
  && apt-get -y install --no-install-recommends openssh-server \
  && apt-get clean

USER vscode

ARG INSTALL_MAVEN="false"
ARG MAVEN_VERSION=""

ARG INSTALL_GRADLE="true"
ARG GRADLE_VERSION=""

ARG NODE_VERSION="lts/*"

RUN if [ "${INSTALL_MAVEN}" = "true" ]; then \
  bash -c "umask 0002 && . /usr/local/sdkman/bin/sdkman-init.sh && sdk install maven \"${MAVEN_VERSION}\""; \
  fi \
  && if [ "${INSTALL_GRADLE}" = "true" ]; then \
  bash -c "umask 0002 && . /usr/local/sdkman/bin/sdkman-init.sh && sdk install gradle \"${GRADLE_VERSION}\""; \
  fi \
  && if [ "${NODE_VERSION}" != "none" ]; then \
  bash -c "umask 0002 && . /usr/local/share/nvm/nvm.sh && nvm install ${NODE_VERSION} 2>&1"; \
  fi

# [Optional] Uncomment this line to install global node packages.
# RUN su ${USERNAME} -c "source /usr/local/share/nvm/nvm.sh && npm install -g <your-package-here>" 2>&1

CMD [ "sleep", "infinity" ]
