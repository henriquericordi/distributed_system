using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace WS_C____
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            WS.WSAndroidClient client = new WS.WSAndroidClient();
            WS.livro livro = client.retornaLivro();
            MessageBox.Show(livro.nome);

            WS.livro[] lista = client.retornaLista();
            String nomeslivros = "";
            for (int i = 0; i < lista.Length; i++)
            {
                nomeslivros += lista[i].nome + "\n";
            }
            MessageBox.Show(nomeslivros);
        }
    }
}
