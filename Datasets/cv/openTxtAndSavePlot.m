nome = "berlin52-plot.txt";
load(nome);
plot(berlin52_plot(:,2), berlin52_plot(:,3), 'o');
saveas(gcf, '../../berlin52-plot.jpg');