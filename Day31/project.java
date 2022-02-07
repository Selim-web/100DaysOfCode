@Proxy : 

  public Map<LocalDate, Integer> getConsumption(){
        String energiesUrl = props.getApiUrl() + "/chauffage/consumption";
        RestTemplate template = new RestTemplate();
        ResponseEntity<Map<LocalDate, Integer>> entity = template.exchange(energiesUrl, HttpMethod.GET, null,
                new ParameterizedTypeReference<Map<LocalDate, Integer>>() {
                });
        return entity.getBody();
    }

@Service : 

 public Map<LocalDate, Integer> getConsumption() {
        return proxy.getConsumption();
    }

@Controller : 

  @GetMapping("/Surveillance")
    public String Surveillance(Model model) {
        Map<LocalDate, Integer> data = heatingDwpService.getConsumption();
        
        model.addAttribute("keySet",data.keySet());
        model.addAttribute("values",data.values());
        System.out.println(data);
        return "/EquipmentDwp/Surveillance";
    }

@Service in backend : 

public Map<LocalDate,Integer> ShowConsumption() {
        List<ConsumptionDwp> list = consumptionDwpRepo.getConsumptionDwpByDateAndEnergie();
        LinkedHashMap<LocalDate, Integer> map = new LinkedHashMap<>();
        for (ConsumptionDwp consumption: list) {    // Foreach loup to convert List<ConsumptionDwp> to Map<,>
            map.put(consumption.getDate(),consumption.getEnergie());
        }
           return map;
    }