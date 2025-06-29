Feature: Endpoint GET/PET

  Scenario: Validar busca de pet cadastrado
    Given envio uma requisicao com idPet
    Then aguardo json com PET consultado

  Scenario: Validar busca de pet inexistente
    Given envio uma requisicao com idPet invalido
    Then aguardo json mensagem de nao encontrato