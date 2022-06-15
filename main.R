
#--             We are going to need these two libraries                    --#
require(curl)
require(tidyr)

wd <- "~/Git/dhis-excell-data-import/"
setwd(wd)
source(file = 'misc_fuctions.R')

# Login credentials
base.url<-"http://localhost:8080/dhis/"
username<-"Agnaldo.Samuel"
password<-"MysticHigh2020!"


#Programa Livro de Registo de Pacientes com Tuberculose

program.id <- 'VF4oiWHRMr3'  # Programa Livro de Registo de Pacientes com Tuberculose
org.unit <- 'ebcn8hWYrg3'  # khamavota
program.stage.id <- 'uUiG6lVDpPa' # Historico Clinico

# DHIS API URL
# orgUnits: Cidade De Maputo: http://mail.ccsaude.org.mz:8080/dhis/api/26/organisationUnits/ebcn8hWYrg3?includeDescendants=true



dhisLogin(username,password,base.url)

# Lista das US  da Cidade de Maputo
#  OrganizationUnit id= ebcn8hWYrg3 (Cidade de Maputo)
unidadesSanitarias <- getOrganizationUnits(base.url,org.unit)

# Todos data Elements do DHIS2
dataElements <- getDataElements(base.url)
dataElements$name <- as.character(dataElements$name)
dataElements$shortName <- as.character(dataElements$shortName)
dataElements$id <- as.character(dataElements$id)