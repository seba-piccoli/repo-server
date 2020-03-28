export MODEL_BASENAME=model
export REPO_NAME=repo-server
export GITHUB_ORGANIZATION=kode-konveyor
export CONSISTENCY_INPUTS=model.rich shippable/behaviours.xml
LANGUAGE=java
BEFORE_ALL=runapache

include /usr/local/toolchain/rules.java

runapache:
	-tools/killApache
	tools/runApache
	touch runapache

delink:
	mkdir -p modelparts/metamodel
	zenta-xslt-runner -xsl:xslt/delink.xslt -s:$(MODEL_BASENAME).zenta -o:modelparts/$(MODEL_BASENAME).zentapart -im:delink

$(MODEL_BASENAME).zenta:
	zenta-xslt-runner -xsl:xslt/delink.xslt  -s:.zentasources -im:prepare|sed 's/<.*>//'|bash
	zenta-xslt-runner -xsl:xslt/delink.xslt -o:$(MODEL_BASENAME).zenta -s:modelparts/$(MODEL_BASENAME).zentapart -im:link

